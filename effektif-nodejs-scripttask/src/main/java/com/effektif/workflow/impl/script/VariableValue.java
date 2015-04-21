package com.effektif.workflow.impl.script;/* Copyright (c) 2015, Effektif GmbH.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

import java.util.HashMap;
import java.util.Map;

/**
 * A script variable data transfer object, to be serialised as JSON and sent to the script service.
 *
 * @author Peter Hilton
 */
public class VariableValue {

  private Object value;
  private Map<String,String> type = new HashMap<>();

  public VariableValue(String typeName, Object value) {
    type.put("name", typeName);
    this.value = value;
  }

  public Object getValue() {
    return value;
  }

  public Map<String, String> getType() {
    return type;
  }
}
