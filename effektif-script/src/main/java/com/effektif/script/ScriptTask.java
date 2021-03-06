/*
 * Copyright (c) 2013, Effektif GmbH.  All rights reserved.
 */
package com.effektif.script;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.effektif.workflow.api.activities.NoneTask;
import com.effektif.workflow.api.bpmn.BpmnElement;
import com.effektif.workflow.api.bpmn.BpmnReader;
import com.effektif.workflow.api.bpmn.BpmnWriter;
import com.effektif.workflow.api.bpmn.XmlElement;
import com.effektif.workflow.api.json.TypeName;
import com.effektif.workflow.api.workflow.Script;


/**
 * A script task - JavaScript code that will be executed by the process engine.
 *
 * @see <a href="https://github.com/effektif/effektif/wiki/Script-Task">Script Task</a>
 * @author Tom Baeyens
 */
@TypeName("scriptTask")
@BpmnElement("scriptTask")
public class ScriptTask extends NoneTask {

  protected Script script;
  
//  @Override
//  public void readJson(JsonReader r) {
//    script = r.readObject("script");
//    super.readJson(r);
//  }
//
//  @Override
//  public void writeJson(JsonWriter w) {
//    super.writeJson(w);
//    w.writeWritable("script", script);
//  }

  @Override
  public void readBpmn(BpmnReader r) {
    r.startExtensionElements();
    script = new Script();
    script.setLanguage(r.readTextEffektif("language"));
    script.setScript(r.readTextEffektif("script"));
    List<XmlElement> mappingElements = r.readElementsEffektif("mapping");
    Map<String, String> mappings = null;
    for (XmlElement mappingElement: mappingElements) {
      r.startElement(mappingElement);
      if (mappings==null) {
        mappings = new HashMap<>();
      }
      String scriptVariableName = r.readStringAttributeEffektif("scriptVariableName");
      String workflowVariableId = r.readStringAttributeEffektif("workflowVariableId");
      mappings.put(scriptVariableName, workflowVariableId);
      r.endElement();
    }
    script.setMappings(mappings);
    r.endExtensionElements();
    super.readBpmn(r);
  }

  @Override
  public void writeBpmn(BpmnWriter w) {
    super.writeBpmn(w);
    if (script!=null) {
      w.startExtensionElements();
      w.writeTextElementEffektif("language", script.getLanguage());
      w.writeCDataTextEffektif("script", script.getScript());
      Map<String, String> mappings = script.getMappings();
      if (mappings!=null) {
        for (String scriptVariableName: mappings.keySet()) {
          String workflowVariableId = mappings.get(scriptVariableName);
          w.startElementEffektif("mapping");
          w.writeStringAttributeEffektif("scriptVariableName", scriptVariableName);
          w.writeStringAttributeEffektif("workflowVariableId", workflowVariableId);
          w.endElement();
        }
      }
      w.endExtensionElements();
    }
  }

  @Override
  public ScriptTask id(String id) {
    super.id(id);
    return this;
  }

  public ScriptTask script(Script script) {
    this.script = script;
    return this;
  }
  
  public ScriptTask script(String script) {
    if (this.script == null) {
      this.script = new Script();
    }
    this.script.script(script);
    return this;
  }

  public ScriptTask scriptMapping(String scriptVariableName, String variableId) {
    if (this.script == null) {
      this.script = new Script();
    }
    this.script.mapping(scriptVariableName, variableId);
    return this;
  }
  
  public Script getScript() {
    return script;
  }
  
  public void setScript(Script script) {
    this.script = script;
  }
}
