package com.devaeon.todoCompose.data.source.remote

/**
 * Main entry point for accessing tasks data from the network.
 *
 */
interface NetworkDataSource {

    suspend fun loadTasks(): List<NetworkTask>

    suspend fun saveTasks(tasks: List<NetworkTask>)
}