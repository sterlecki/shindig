/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.shindig.extras.as;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import org.apache.shindig.extras.as.opensocial.service.ActivityStreamsHandler;
import org.apache.shindig.extras.as.opensocial.spi.ActivityStreamService;
import org.apache.shindig.extras.as.sample.ActivityStreamsJsonDbService;
import org.apache.shindig.social.sample.spi.JsonDbOpensocialService;

/**
 * Configures the Extra modules in shindig-extras.
 */
public class ActivityStreamsGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(ActivityStreamService.class).to(ActivityStreamsJsonDbService.class);

    Multibinder<Object> handlerBinder = Multibinder.newSetBinder(binder(), Object.class, Names.named("org.apache.shindig.handlers"));
    handlerBinder.addBinding().toInstance(ActivityStreamsHandler.class);
  }
}