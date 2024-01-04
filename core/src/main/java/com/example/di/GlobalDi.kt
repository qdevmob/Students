package com.example.di

import kotlin.reflect.KClass

interface GlobalDi {

    fun <T : Any> get(class_: KClass<T>): T
    fun <T : Any> add(key: KClass<T>, object_: T)
}

interface StudentDiComponent{
    fun getStudentDi():GlobalDi = DiProvider.di
}


inline fun <reified T : Any> studentAppDi(): Lazy<T> =
    lazy(LazyThreadSafetyMode.SYNCHRONIZED) { DiProvider.di.get(T::class) }

