/* Copyright (c) 2014, Effektif GmbH.
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
package com.effektif.workflow.api.model;

import java.util.HashMap;
import java.util.Map;

import com.effektif.workflow.api.types.DataType;


/**
 * @author Tom Baeyens
 */
public class DataContainer {

  protected Map<String,TypedValue> data;

  public Object getData(String key) {
    TypedValue value = data!=null ? data.get(key) : null;
    return value!=null ? value.getValue() : null;
  }
  
  public void setData(String key, Object value) {
    setTypedValue(key, new TypedValue(value));
  }

  public void setData(String key, Object value, DataType dataType) {
    setTypedValue(key, new TypedValue(value, dataType));
  }
  
  public void setTypedValue(String key, TypedValue value) {
    if (data==null) {
      data = new HashMap<>();
    }
    data.put(key, value);
  }
  
  public DataContainer data(String key, Object value) {
    setData(key, value);
    return this;
  }

  public DataContainer data(String key, Object value, DataType dataType) {
    setData(key, value, dataType);
    return this;
  }

  public DataContainer typedValue(String key, TypedValue value) {
    setTypedValue(key, value);
    return this;
  }

  public Map<String, TypedValue> getData() {
    return data;
  }
  
}
