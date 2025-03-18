package com.devaeon.todoCompose.di

import android.content.Context
import androidx.room.Room
import com.devaeon.todoCompose.data.DefaultTaskRepository
import com.devaeon.todoCompose.data.TaskRepository
import com.devaeon.todoCompose.data.source.local.TaskDao
import com.devaeon.todoCompose.data.source.local.TaskDatabase
import com.devaeon.todoCompose.data.source.remote.NetworkDataSource
import com.devaeon.todoCompose.data.source.remote.TaskNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTaskRepository(repository: DefaultTaskRepository): TaskRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(dataSource: TaskNetworkDataSource): NetworkDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): TaskDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TaskDatabase::class.java,
            "Tasks.db"
        ).build()
    }

    @Provides
    fun provideTaskDao(database: TaskDatabase): TaskDao = database.taskDao()
}
