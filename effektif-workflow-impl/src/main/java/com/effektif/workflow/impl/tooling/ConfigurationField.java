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
package com.effektif.workflow.impl.tooling;


public class ConfigurationField {
  
  protected String label;
  protected String key;
  protected String description;
  protected FieldType type;

  public ConfigurationField() {
  }

  public ConfigurationField(String label) {
    this.label = label;
  }
  
  public String getLabel() {
    return this.label;
  }
  public void setLabel(String label) {
    this.label = label;
  }
  public ConfigurationField label(String label) {
    this.label = label;
    return this;
  }
  
  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public ConfigurationField description(String description) {
    this.description = description;
    return this;
  }

  public String getKey() {
    return this.key;
  }
  public void setKey(String key) {
    this.key = key;
  }
  public ConfigurationField key(String key) {
    this.key = key;
    return this;
  }
  public FieldType getType() {
    return this.type;
  }
  public void setType(FieldType type) {
    this.type = type;
  }
  public ConfigurationField type(FieldType type) {
    this.type = type;
    return this;
  }

}
