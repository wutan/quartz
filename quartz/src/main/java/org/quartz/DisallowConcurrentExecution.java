/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package org.quartz;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that marks a {@link Job} class as one that must not have multiple
 * instances executed concurrently (where instance is based-upon a {@link JobDetail} 
 * definition - or in other words based upon a {@link JobKey}).
 *
 * @see PersistJobDataAfterExecution
 * 
 * @author jhouse
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DisallowConcurrentExecution {

    // 在某一个JobDetail实例到点运行之后，在其运行结束之前, 不会再发起一次该JobDetail实例的调用，即使设置的该JobDetail实例的定时执行时间到了
    // JobDetail实例之间互不影响，注解之作用于同一个JobDetail,不同的JobDetail实例不受影响
}
