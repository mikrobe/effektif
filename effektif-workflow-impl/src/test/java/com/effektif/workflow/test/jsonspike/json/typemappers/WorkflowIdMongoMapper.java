package com.effektif.workflow.test.jsonspike.json.typemappers;/* Copyright (c) 2015, Effektif GmbH.
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

import java.lang.reflect.Type;

import com.effektif.workflow.api.model.WorkflowId;
import com.effektif.workflow.test.jsonspike.json.JsonFieldReader;
import com.effektif.workflow.test.jsonspike.json.JsonFieldWriter;
import com.effektif.workflow.test.jsonspike.json.TypeMapper;

/**
 * Maps a {@link WorkflowId} to a MongoDB JSON ID field for serialisation and deserialisation.
 *
 * TODO Can this subclass WorkflowIdStreamMapper?
 * @author Peter Hilton
 */
public class WorkflowIdMongoMapper implements TypeMapper<WorkflowId> {

  @Override
  public Class<WorkflowId> getMappedClass() {
    return WorkflowId.class;
  }

  // TODO
  @Override
  public WorkflowId read(Object jsonValue, Type type, JsonFieldReader jsonFieldReader) {
    return null;
  }

  @Override
  public void write(WorkflowId objectValue, JsonFieldWriter jsonFieldWriter) {
    jsonFieldWriter.objectStart();
    jsonFieldWriter.writeFieldName("$oid");
    jsonFieldWriter.writeString(objectValue.getInternal());
    jsonFieldWriter.objectEnd();
  }
}
