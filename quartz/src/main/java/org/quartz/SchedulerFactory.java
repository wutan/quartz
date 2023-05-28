
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

import java.util.Collection;

/**
 * Provides a mechanism for obtaining client-usable handles to <code>Scheduler</code>  instances.
 * 
 * @see Scheduler
 * @see org.quartz.impl.StdSchedulerFactory
 * 
 * @author James House
 *
 *   SchedulerFacotory 是一个接口，它有两个实现，
 *          1.  StdSchedulerFacotory 根据配置文件来创建 Scheduler
 *          2.  DirectSchedulerFactory 主要通过编码对 Scheduler 控制，通常为了侵入性更小、实现更方便
 *
 *          我们用 StdSchedulerFacotory 类型来创建 StdScheduler，
 *                  quartz.properties 里面的配置都对应到这个 StdSchedulerFactory 中，
 *                  所以对某个配置不明白已经该配置的默认值可以看 StdSchedulerFactory 中获取配置的代码。
 */
public interface SchedulerFactory {

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 
     * Interface.
     * 
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * <p>
     * Returns a client-usable handle to a <code>Scheduler</code>.
     * </p>
     * 
     * @throws SchedulerException
     *           if there is a problem with the underlying <code>Scheduler</code>.
     */
    Scheduler getScheduler() throws SchedulerException;

    /**
     * <p>
     * Returns a handle to the Scheduler with the given name, if it exists.
     * </p>
     */
    Scheduler getScheduler(String schedName) throws SchedulerException;

    /**
     * <p>
     * Returns handles to all known Schedulers (made by any SchedulerFactory
     * within this jvm.).
     * </p>
     */
    Collection<Scheduler> getAllSchedulers() throws SchedulerException;

}
