package meteor.util

import java.net.Authenticator
import java.net.PasswordAuthentication

object Proxy {
    class ProxyAuth constructor(user: String, password: String?) : Authenticator() {
        val auth: PasswordAuthentication

        init {
            auth = PasswordAuthentication(user, password?.toCharArray() ?: charArrayOf())
        }

        override fun getPasswordAuthentication(): PasswordAuthentication {
            return auth
        }
    }

    fun handle(args: Array<String>) {
        var idx = 0
        args.forEach { currentArg ->
            if (currentArg == "-socks5Proxy") {
                val proxy: Array<String> =
                        args[idx + 1].split(":".toRegex()).dropLastWhile { it.isEmpty() }
                                .toTypedArray()
                if (proxy.size >= 2) {
                    println("using socks5 URL: ${proxy[0]}")
                    System.setProperty("socksProxyHost", proxy[0])
                    System.setProperty("socksProxyPort", proxy[1])
                }
                if (proxy.size >= 4) {
                    println("using socks5 USER: ${proxy[2]}")
                    System.setProperty("java.net.socks.username", proxy[2])
                    System.setProperty("java.net.socks.password", proxy[3])
                    Authenticator.setDefault(ProxyAuth(proxy[2], proxy[3]))
                }
            } else if (currentArg == "-httpProxy") {
                val proxy: Array<String> =
                        args[idx + 1].split(":".toRegex()).dropLastWhile { it.isEmpty() }
                                .toTypedArray()
                if (proxy.size >= 2) {
                    System.setProperty("http.proxyHost", proxy[0])
                    System.setProperty("http.proxyPort", proxy[1])
                }
                if (proxy.size >= 4) {
                    Authenticator.setDefault(ProxyAuth(proxy[2], proxy[3]))
                }
            } else if (currentArg == "-httpsProxy") {
                println("Using HTTPS Proxy")
                val proxy: Array<String> =
                        args[idx + 1].split(":".toRegex()).dropLastWhile { it.isEmpty() }
                                .toTypedArray()
                if (proxy.size >= 2) {
                    System.setProperty("https.proxyHost", proxy[0])
                    System.setProperty("https.proxyPort", proxy[1])
                }
                if (proxy.size >= 4) {
                    Authenticator.setDefault(ProxyAuth(proxy[2], proxy[3]))
                }
            }
            idx++
        }
    }
}