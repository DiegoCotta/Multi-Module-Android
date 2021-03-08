package com.example.android.core_impl.di.injector

internal class ComponentHolder<T : ComponentApi>(
    private val componentFactory: ComponentFactory<T>,
    private val componentsManager: ComponentManager
) {

    private var component: T? = null
    private var clientCount = 0

    @Synchronized
    fun getOrCreate(): T {
        if (component == null) {
            component = componentFactory.create(componentsManager)
        }
        if (component!!.isReleasable()) {
            clientCount++
        }
        return component!!
    }

    @Synchronized
    fun getWithoutRef(): T {
        if (component == null) {
            throw IllegalStateException("Component isn't created yet!")
        }
        return component!!
    }

    @Synchronized
    fun release() {
        if (component!!.isReleasable()) {
            if (component == null) return
            clientCount--
            if (clientCount <= 0) {
                releaseComponent()
            }
        }
    }

    @Throws
    private fun releaseComponent() {
        component = null
    }
}