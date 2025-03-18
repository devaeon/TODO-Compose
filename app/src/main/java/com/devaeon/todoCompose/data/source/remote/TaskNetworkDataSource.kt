package com.devaeon.todoCompose.data.source.remote

import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject


class TaskNetworkDataSource @Inject constructor() : NetworkDataSource {

    // A mutex is used to ensure that reads and writes are thread-safe.
    private val accessMutex = Mutex()
    private var tasks = listOf(
        NetworkTask(
            id = "PISA",
            title = "Build tower in Pisa",
            shortDescription = "Ground looks good, no foundation work required.",
            priority = TaskPriority.HIGH,
            status = TaskStatus.COMPLETE
        ),
        NetworkTask(
            id = "TACOMA",
            title = "Finish bridge in Tacoma",
            shortDescription = "Found awesome girders at half the cost!",
            priority = TaskPriority.MEDIUM,
            status = TaskStatus.ACTIVE
        ),
        NetworkTask(
            id = "PAKISTAN",
            title = "Programmer",
            shortDescription = "Hi I am programmer from pakistan!",
            priority = TaskPriority.IMMEDIATE,
            status = TaskStatus.TODO
        ),
        NetworkTask(
            id = "USA",
            title = "Programmer",
            shortDescription = "Hi I am programmer from USA!",
            priority = TaskPriority.LOW,
            status = TaskStatus.CANCELLED
        )
    )

    override suspend fun loadTasks(): List<NetworkTask> = accessMutex.withLock {
        delay(SERVICE_LATENCY_IN_MILLIS)
        return tasks
    }

    override suspend fun saveTasks(newTasks: List<NetworkTask>) = accessMutex.withLock {
        delay(SERVICE_LATENCY_IN_MILLIS)
        tasks = newTasks
    }
}

private const val SERVICE_LATENCY_IN_MILLIS = 2000L
