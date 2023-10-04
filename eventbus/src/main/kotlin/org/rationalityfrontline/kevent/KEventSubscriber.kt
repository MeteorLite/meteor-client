/*
 * Copyright 2020-2021 RationalityFrontline
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

@file:Suppress("NOTHING_TO_INLINE", "unused", "PropertyName")

package org.rationalityfrontline.kevent

/**
 * Convenient interface for adding and removing subscribers
 */
interface KEventSubscriber {
    /**
     * The subscription tag of this object.
     */
    val SUBSCRIBER_TAG: String get() = "${this::class.java.simpleName}@${this.hashCode()}"
    val KEVENT_INSTANCE: KEvent get() = KEVENT
}

/**
 * Add a new subscriber with tag of [KEventSubscriber.SUBSCRIBER_TAG]. Subscribers with same [eventType] and [consumer] can only be added once.
 *
 * @param eventType event type that this subscriber subscribers.
 * @param consumer event consumer function.
 * @param threadMode thread mode, see [SubscriberThreadMode].
 * @param priority priority, bigger is higher.
 * @return true if subscription is successful, else false.
 */
inline fun <reified T : Any> KEventSubscriber.subscribe(
    threadMode: SubscriberThreadMode = KEVENT_INSTANCE.defaultThreadMode,
    priority: Int = 0,
    noinline consumer: EventConsumer<T>
): Boolean = KEVENT_INSTANCE.subscribe(threadMode, priority, SUBSCRIBER_TAG, consumer)

/**
 * Add a new subscriber with tag of [KEventSubscriber.SUBSCRIBER_TAG]. Subscribers with same [eventType] and [consumer] can only be added once.
 *
 * @param eventType event type that this subscriber subscribers.
 * @param consumer event consumer function.
 * @param threadMode thread mode, see [SubscriberThreadMode].
 * @param priority priority, bigger is higher.
 * @return true if subscription is successful, else false.
 */
inline fun <T : Any> KEventSubscriber.subscribe(
    eventType: Class<*>,
    noinline consumer: EventConsumer<T>,
    threadMode: SubscriberThreadMode = KEVENT_INSTANCE.defaultThreadMode,
    priority: Int = 0
): Boolean = KEVENT_INSTANCE.subscribe(eventType, consumer, threadMode, priority, SUBSCRIBER_TAG)

/**
 * Add a new subscriber with multiple [eventTypes] and tag of [KEventSubscriber.SUBSCRIBER_TAG]. Subscribers with same eventType and [consumer] can only be added once.
 *
 * @param eventTypes event types that this subscriber subscribers.
 * @param consumer event consumer function.
 * @param threadMode thread mode, see [SubscriberThreadMode].
 * @param priority priority, bigger is higher.
 * @return true if subscription is successful, else false.
 */
inline fun <T : Any> KEventSubscriber.subscribeMultiple(
    eventTypes: Collection<Class<*>>,
    threadMode: SubscriberThreadMode = KEVENT_INSTANCE.defaultThreadMode,
    priority: Int = 0,
    noinline consumer: EventConsumer<T>
): Boolean = KEVENT_INSTANCE.subscribeMultiple(eventTypes, threadMode, priority, SUBSCRIBER_TAG, consumer)

/**
 * Add a new subscriber with multiple [eventTypes] and tag of [KEventSubscriber.SUBSCRIBER_TAG]. Subscribers with same eventType and [consumer] can only be added once.
 *
 * @param eventTypes event types that this subscriber subscribers.
 * @param consumer event consumer function.
 * @param threadMode thread mode, see [SubscriberThreadMode].
 * @param priority priority, bigger is higher.
 * @return true if subscription is successful, else false.
 */
inline fun <T : Any> KEventSubscriber.subscribeMultiple(
    eventTypes: Collection<Class<*>>,
    noinline consumer: EventConsumer<T>,
    threadMode: SubscriberThreadMode = KEVENT_INSTANCE.defaultThreadMode,
    priority: Int = 0,
): Boolean = KEVENT_INSTANCE.subscribeMultiple(eventTypes, consumer, threadMode, priority, SUBSCRIBER_TAG)

/**
 * Unsubscribe the subscriber with [eventType] and [consumer].
 *
 * @return true if subscriber exists and unsubscription is successful, else false.
 */
inline fun <T : Any> KEventSubscriber.unsubscribe(
    eventType: Class<*>,
    noinline consumer: EventConsumer<T>
): Boolean = KEVENT_INSTANCE.unsubscribe(eventType, consumer)

/**
 * Unsubscribe the subscriber with [eventTypes] and [consumer].
 *
 * @return true if subscriber exists and any of the unsubscription is successful, else false.
 */
inline fun <T : Any> KEventSubscriber.unsubscribeMultiple(
    eventTypes: Collection<Class<*>>,
    noinline consumer: EventConsumer<T>
): Boolean = KEVENT_INSTANCE.unsubscribeMultiple(eventTypes, consumer)

/**
 * Unsubscribe all subscribers with tag of [KEventSubscriber.SUBSCRIBER_TAG].
 *
 * @return true if subscriber exists and any of the unsubscription is successful, else false.
 */
inline fun KEventSubscriber.unsubscribeAll(): Boolean = KEVENT_INSTANCE.removeSubscribersByTag(SUBSCRIBER_TAG)

/**
 * Cancel further event dispatching, this should only be used together with [EventDispatchMode.SEQUENTIAL] or [EventDispatchMode.POSTING].
 *
 * @return true if the event get cancelled, false if the event is already cancelled before.
 */
inline fun <T : Any> KEventSubscriber.cancelEvent(event: Event<T>): Boolean = KEVENT_INSTANCE.cancelEvent(event)