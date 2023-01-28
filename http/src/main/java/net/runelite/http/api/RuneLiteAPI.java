/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.runelite.http.api.gson.ColorTypeAdapter;
import net.runelite.http.api.gson.IllegalReflectionExclusion;
import net.runelite.http.api.gson.InstantTypeAdapter;
import okhttp3.*;
import meteor.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RuneLiteAPI {

  public static final OkHttpClient CLIENT;
  public static final Gson GSON;
  public static final MediaType JSON = MediaType.parse("application/json");
  private static final Logger logger = Logger.Companion.getLogger(RuneLiteAPI.class);
  private static final String BASE = "https://api.runelite.net";
  private static final String WSBASE = "http://api.runelite.net/ws";
  private static final String STATICBASE = "http://static.runelite.net";
  private static final String METEOR_SESSION = "http://session.meteor-client.com";
  public static String userAgent;
  private static String version;

  private static final String MAVEN_METADATA = "https://repo.runelite.net/net/runelite/runelite-parent/maven-metadata.xml";
  private static String upstreamVersion = "1.8.19-SNAPSHOT";

  static {
    parseMavenVersion();
    version = upstreamVersion;
    userAgent = "RuneLite/" + version + "-";
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    List<ConnectionSpec> specs = new ArrayList<>();
    specs.add(ConnectionSpec.CLEARTEXT);
    specs.add(ConnectionSpec.MODERN_TLS);
    specs.add(ConnectionSpec.COMPATIBLE_TLS);
    builder.connectionSpecs(specs);

    CLIENT = builder
        .pingInterval(30, TimeUnit.SECONDS)
        .addNetworkInterceptor(new Interceptor() {

          @Override
          public Response intercept(Chain chain) throws IOException {
            Request userAgentRequest = chain.request()
                .newBuilder()

                .header("User-Agent", userAgent)
                .build();
            return chain.proceed(userAgentRequest);
          }
        })
        .build();

    GsonBuilder gsonBuilder = new GsonBuilder();

    gsonBuilder
        .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
        .registerTypeAdapter(Color.class, new ColorTypeAdapter());

    boolean assertionsEnabled = false;
    assert assertionsEnabled = true;
    if (assertionsEnabled) {
      IllegalReflectionExclusion jbe = new IllegalReflectionExclusion();
      gsonBuilder.addSerializationExclusionStrategy(jbe);
      gsonBuilder.addDeserializationExclusionStrategy(jbe);
    }

    GSON = gsonBuilder.create();
  }

  public static HttpUrl getSessionBase() {
    return HttpUrl.parse(METEOR_SESSION);
  }

  public static HttpUrl getApiBase() {
    final String prop = System.getProperty("runelite.http-service.url");

    if (prop != null && !prop.isEmpty()) {
      return HttpUrl.parse(prop);
    }

    return HttpUrl.parse(BASE + "/runelite-" + getVersion());
  }

  public static HttpUrl getStaticBase() {
    final String prop = System.getProperty("runelite.static.url");

    if (prop != null && !prop.isEmpty()) {
      return HttpUrl.parse(prop);
    }

    return HttpUrl.parse(STATICBASE);
  }

  public static HttpUrl getWsEndpoint() {
    final String prop = System.getProperty("runelite.ws.url");

    if (prop != null && !prop.isEmpty()) {
      return HttpUrl.parse(prop);
    }

    return HttpUrl.parse(WSBASE);
  }

  public static String getVersion() {
    return version;
  }

  public static void setVersion(String version) {
    RuneLiteAPI.version = version;
  }

  private static void parseMavenVersion()
  {
    try (ByteArrayInputStream fis = new ByteArrayInputStream(downloadUrl(new URL(MAVEN_METADATA))))
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(false);
      factory.setIgnoringElementContentWhitespace(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(fis);
      NodeList versionList = doc.getElementsByTagName("version");
      for (int i = 0; i != versionList.getLength(); i++)
      {
        Node node = versionList.item(i);
        if (node.getTextContent() != null && !node.getTextContent().endsWith("SNAPSHOT"))
        {
          upstreamVersion = node.getTextContent();
        }
      }
    }
    catch (ParserConfigurationException | IOException | SAXException ex)
    {
      ex.printStackTrace();
    }
  }

  private static byte[] downloadUrl(URL toDownload)
  {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    InputStream stream;
    try
    {
      byte[] chunk = new byte[4096];
      int bytesRead;
      URLConnection conn = toDownload.openConnection();
      conn.setRequestProperty("User-Agent", userAgent);
      stream = conn.getInputStream();

      while ((bytesRead = stream.read(chunk)) > 0)
      {
        outputStream.write(chunk, 0, bytesRead);
      }
      stream.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
      return null;
    }

    return outputStream.toByteArray();
  }
}
