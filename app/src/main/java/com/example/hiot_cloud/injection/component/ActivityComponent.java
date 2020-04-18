/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hiot_cloud.injection.component;


import com.example.hiot_cloud.injection.PerActivity;
import com.example.hiot_cloud.injection.module.ActivityModule;
import com.example.hiot_cloud.main.MainActivity;
import com.example.hiot_cloud.test.mvptest.TestMVPActivity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation:
 */
@PerActivity
//@Component指定了 modules 对应的是ActivityModule
//dependencies是依赖于前面定义的ApplicationComponent注入器
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    //定义inject方法
    //有几个活动就要定义几个inject
    void inject(MainActivity mainActivity);

    void inject(TestMVPActivity testMVPActivity);

    @Component.Builder

    //注入器的生成方法
    interface ActivityComponentBuilder {

        ActivityComponent build();

        ActivityComponentBuilder applicationComponent(ApplicationComponent applicationComponent);

        ActivityComponentBuilder activityModule(ActivityModule activityModule);
    }
}
