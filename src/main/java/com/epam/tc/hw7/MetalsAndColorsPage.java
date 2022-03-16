package com.epam.tc.hw7;


import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.forms.MetalsAndColorsForm;

import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @FindBy(css = ".form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".results > li")
    public static List<UIElement> result;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(css = ".logout")
    public Button logOut;

    public static List<String> getActualResult() {
        return result.stream().map(UIElement::getText).collect(Collectors.toList());
    }
}
