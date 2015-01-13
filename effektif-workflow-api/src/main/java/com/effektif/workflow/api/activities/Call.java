/* Copyright 2014 Effektif GmbH.
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
package com.effektif.workflow.api.activities;

import com.effektif.workflow.api.workflow.Activity;
import com.effektif.workflow.api.workflow.Binding;
import com.effektif.workflow.api.workflow.MultiInstance;
import com.effektif.workflow.api.workflow.Timer;
import com.effektif.workflow.api.workflow.Transition;
import com.effektif.workflow.api.workflow.Variable;
import com.fasterxml.jackson.annotation.JsonTypeName;

/* invokes another workflow and ends when the other workflow instance completes */ 
@JsonTypeName("call")
public class Call extends Activity {

  public static final String SUB_WORKFLOW_ID = "subWorkflowId";
  public static final String SUB_WORKFLOW_NAME = "subWorkflowName";
  public static final String INPUT_MAPPINGS = "inputMappings";
  public static final String OUTPUT_MAPPINGS = "outputMappings";
  
  public Call subWorkflowId(String subWorkflowId) {
    setConfigurationBindingValue(SUB_WORKFLOW_ID, subWorkflowId);
    return this;
  }

  public Call subWorkflowIdExpression(String subWorkflowIdExpression) {
    setConfigurationBindingExpression(SUB_WORKFLOW_ID,subWorkflowIdExpression);
    return this;
  }

  public Call subWorkflowIdVariableId(String subWorkflowIdVariableId) {
    setConfigurationBindingVariableId(SUB_WORKFLOW_ID, subWorkflowIdVariableId);
    return this;
  }
  
  // TODO sub workflow name property methods

  public Call inputMappingValue(Object value, String subWorkflowVariableId) {
    addInputMapping(new Binding().value(value), subWorkflowVariableId);
    return this;
  }

  public Call inputMappingVariable(String variableId, String subWorkflowVariableId) {
    addInputMapping(new Binding().variableId(variableId), subWorkflowVariableId);
    return this;
  }

  public Call inputMappingExpression(String expression, String subWorkflowVariableId) {
    addInputMapping(new Binding().expression(expression), subWorkflowVariableId);
    return this;
  }

  public Call addInputMapping(Binding sourceBinding, String destinationVariableId) {
    CallMapping inputCallMapping = new CallMapping()
      .sourceBinding(sourceBinding)
      .destinationVariableId(destinationVariableId);
    addConfiguration(INPUT_MAPPINGS, inputCallMapping);
    return this;
  }

  public Call outputMapping(String calledVariableId, String callerVariableId) {
    outputMapping(new Binding().variableId(calledVariableId), callerVariableId);
    return this;
  }

  public Call outputMapping(Binding calledBinding, String callerVariableId) {
    CallMapping outputMapping = new CallMapping()
      .sourceBinding(calledBinding)
      .destinationVariableId(callerVariableId);
    addConfiguration(OUTPUT_MAPPINGS, outputMapping);
    return this;
  }
  
  @Override
  public Call multiInstance(MultiInstance multiInstance) {
    super.multiInstance(multiInstance);
    return this;
  }

  @Override
  public Call transitionTo(String toActivityId) {
    super.transitionTo(toActivityId);
    return this;
  }

  @Override
  public Call transitionTo(Transition transition) {
    super.transitionTo(transition);
    return this;
  }

  @Override
  public Call activity(Activity activity) {
    super.activity(activity);
    return this;
  }

  @Override
  public Call transition(Transition transition) {
    super.transition(transition);
    return this;
  }

  @Override
  public Call variable(Variable variable) {
    super.variable(variable);
    return this;
  }

  @Override
  public Call timer(Timer timer) {
    super.timer(timer);
    return this;
  }

  @Override
  public Call id(String id) {
    super.id(id);
    return this;
  }

  @Override
  public Call property(String key, Object value) {
    super.property(key, value);
    return this;
  }
}