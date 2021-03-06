/*
 * Copyright 2015 Effektif GmbH.
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
 * limitations under the License.
 */
package com.effektif.workflow.impl.data.types;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.effektif.workflow.api.types.DateType;
import com.effektif.workflow.impl.data.AbstractDataType;
import com.effektif.workflow.impl.data.InvalidValueException;

/**
 * @author Tom Baeyens
 */
public class DateTypeImpl extends AbstractDataType<DateType> {

  public static DateTimeFormatter formatter = ISODateTimeFormat.dateTimeParser();
  public static DateTimeFormatter printer = ISODateTimeFormat.dateTime();

  public DateTypeImpl() {
    super(DateType.INSTANCE);
  }

  @Override
  public Object convertJsonToInternalValue(Object jsonValue) throws InvalidValueException {
    if (jsonValue==null) {
      return null;
    }
    try {
      String timeString = (String) jsonValue;
      return DateTypeImpl.formatter.parseLocalDateTime(timeString);
    } catch (ClassCastException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Object convertInternalToJsonValue(Object internalValue) {
    if (internalValue==null) {
      return null;
    }
    return DateTypeImpl.printer.print((LocalDateTime)internalValue);
  }
}
