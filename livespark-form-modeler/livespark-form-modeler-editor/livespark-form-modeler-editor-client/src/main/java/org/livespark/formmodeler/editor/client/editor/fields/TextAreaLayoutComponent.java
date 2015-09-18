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
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.HelpBlock;
import org.gwtbootstrap3.client.ui.TextArea;
import org.livespark.formmodeler.editor.client.resources.i18n.FieldProperties;
import org.livespark.formmodeler.editor.model.impl.basic.TextAreaFieldDefinition;
import org.uberfire.ext.properties.editor.model.PropertyEditorFieldInfo;
import org.uberfire.ext.properties.editor.model.PropertyEditorType;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pefernan on 9/2/15.
 */
@Dependent
public class TextAreaLayoutComponent extends FieldLayoutComponent<TextAreaFieldDefinition> {

    public TextAreaLayoutComponent() {
    }

    public TextAreaLayoutComponent( String formId, TextAreaFieldDefinition fieldDefinition ) {
        init( formId, fieldDefinition );
    }

    @Override
    public IsWidget generateWidget() {
        if (fieldDefinition == null) return null;

        FormGroup group = new FormGroup(  );
        FormLabel label = new FormLabel(  );
        TextArea textArea = new TextArea();
        textArea.setPlaceholder( fieldDefinition.getPlaceHolder() );
        textArea.setVisibleLines(fieldDefinition.getRows());
        textArea.setCharacterWidth(fieldDefinition.getCols());
        textArea.setReadOnly(fieldDefinition.getReadonly());
        label.setText( fieldDefinition.getLabel());
        label.setFor(textArea.getId());
        group.add(label);
        group.add(textArea);
        group.add(new HelpBlock());
        return group;
    }

    @Override
    protected List<PropertyEditorFieldInfo> getCustomFieldProperties() {
        List<PropertyEditorFieldInfo> result = new ArrayList<PropertyEditorFieldInfo>();
        result.add(new PropertyEditorFieldInfo(FieldProperties.INSTANCE.placeholder(), fieldDefinition.getPlaceHolder(), PropertyEditorType.TEXT) {
            @Override
            public void setCurrentStringValue(final String currentStringValue) {
                super.setCurrentStringValue(currentStringValue);
                fieldDefinition.setPlaceHolder(currentStringValue);
            }
        });
        result.add(new PropertyEditorFieldInfo( FieldProperties.INSTANCE.rows(), String.valueOf( fieldDefinition.getRows() ), PropertyEditorType.TEXT ) {
            @Override
            public void setCurrentStringValue( final String currentStringValue ) {
                super.setCurrentStringValue( currentStringValue );
                fieldDefinition.setRows(Integer.decode(currentStringValue));
            }
        });
        result.add(new PropertyEditorFieldInfo( FieldProperties.INSTANCE.columns(), String.valueOf( fieldDefinition.getCols() ), PropertyEditorType.TEXT ) {
            @Override
            public void setCurrentStringValue( final String currentStringValue ) {
                super.setCurrentStringValue( currentStringValue );
                fieldDefinition.setCols(Integer.decode(currentStringValue));
            }
        });
        return result;
    }

    @Override
    public TextAreaLayoutComponent newInstance( String formId, TextAreaFieldDefinition fieldDefinition ) {
        return new TextAreaLayoutComponent( formId, fieldDefinition );
    }

    @Override
    public String getSupportedFieldDefinition() {
        return TextAreaFieldDefinition.class.getName();
    }
}
