/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.saga.format;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.servicecomb.saga.core.Transaction;

public class JacksonRestTransaction extends JacksonRestOperation implements Transaction {

  public JacksonRestTransaction(
      String path,
      String method,
      Map<String, Map<String, String>> params) {
    this(INFINITE_RETRY, path, method, params);
  }

  @JsonCreator
  public JacksonRestTransaction(
      @JsonProperty("retries") int retries,
      @JsonProperty("path") String path,
      @JsonProperty("method") String method,
      @JsonProperty("params") Map<String, Map<String, String>> params) {
    super(path, method, retries <= 0? INFINITE_RETRY : retries, params);
  }
}
