package com.devaeon.todoCompose.data.source.remote

/**
 * Internal model used to represent a task obtained from the network. This is used inside the data
 * layer only.
 *
 * See ModelMappingExt.kt for mapping functions used to convert this model to other
 * models.
 */
data class NetworkTask(
    val id: String,
    val title: String,
    val shortDescription: String,
    val priority: TaskPriority = TaskPriority.LOW,
    val status: TaskStatus = TaskStatus.ACTIVE
)

enum class TaskPriority {
    LOW,
    MEDIUM,
    HIGH,
    IMMEDIATE
}

enum class TaskStatus {
    TODO,
    ACTIVE,
    CANCELLED,
    COMPLETE
}