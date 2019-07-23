/*
* Copyright 2016 by Pulse Systems Inc.,
* All rights reserved.
*
* This software is the confidential and proprietary information
* of Pulse Systems Inc.
*
* @author Christian Davidson
*/
package demoSample;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import java.util.ArrayList;
import java.util.Set;

public class ArrayListStringCell implements Cell<ArrayList<String>> {
    @Override
    public boolean dependsOnSelection() {
        return false;
    }

    @Override
    public Set<String> getConsumedEvents() {
        return null;
    }

    @Override
    public boolean handlesSelection() {
        return false;
    }

    @Override
    public boolean isEditing(Context context, Element element, ArrayList<String> strings) {
        return false;
    }

    @Override
    public void onBrowserEvent(Context context, Element element, ArrayList<String> strings, NativeEvent nativeEvent, ValueUpdater<ArrayList<String>> valueUpdater) {

    }

    @Override
    public void render(Context context, ArrayList<String> strings, SafeHtmlBuilder safeHtmlBuilder) {
        if (strings == null) {
            return;
        }

        for (String value : strings) {
            safeHtmlBuilder.appendHtmlConstant("<div>");
            safeHtmlBuilder.appendHtmlConstant(value);
            safeHtmlBuilder.appendHtmlConstant("</div>");
        }
    }

    @Override
    public boolean resetFocus(Context context, Element element, ArrayList<String> strings) {
        return false;
    }

    @Override
    public void setValue(Context context, Element element, ArrayList<String> strings) {
        //do nothing
    }
}

