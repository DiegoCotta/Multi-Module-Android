/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architectureexample.di

import android.content.Context
import com.example.android.architectureexample.CustomApplication
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.RootComponentManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: CustomApplication): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideComponentManager(): ComponentManager = RootComponentManager
}
