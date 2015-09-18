/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.livespark.formmodeler.editor.client.editor.fields;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.datepicker.client.DatePicker;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.HelpBlock;
import org.livespark.formmodeler.editor.model.impl.basic.DateBoxFieldDefinition;
import org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by pefernan on 7/27/15.
 */
@Dependent
public class DateBoxLayoutComponent extends FieldLayoutComponent<DateBoxFieldDefinition>  {

    public DateBoxLayoutComponent() {
    }

    public DateBoxLayoutComponent( String formId, DateBoxFieldDefinition fieldDefinition ) {
        init(formId, fieldDefinition);
    }

    @Override
    public IsWidget generateWidget() {
        if (fieldDefinition == null) return null;

        FormGroup group = new FormGroup(  );
        FormLabel label = new FormLabel(  );
        DatePicker box = new DatePicker();
        label.setText( fieldDefinition.getLabel() );
        label.setFor( box.getElement().getId() );
        group.add( label );
        group.add( box );
        group.add( new HelpBlock() );
        return group;
    }

    @Override
    protected List<PropertyEditorFieldInfo> getCustomFieldProperties() {
        return null;
    }

    @Override
    public DateBoxLayoutComponent newInstance( String formId, DateBoxFieldDefinition fieldDefinition ) {
        return new DateBoxLayoutComponent( formId, fieldDefinition );
    }

    @Override
    public String getSupportedFieldDefinition() {
        return DateBoxFieldDefinition.class.getName();
    }
}
