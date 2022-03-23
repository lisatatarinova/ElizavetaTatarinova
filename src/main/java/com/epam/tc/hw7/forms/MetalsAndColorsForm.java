package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalAndColors;

public class MetalsAndColorsForm extends Form<MetalAndColors> {

    @UI("[name=custom_radio_odd]")
    public RadioButtons oddButton;

    @UI("[name=custom_radio_even]")
    public RadioButtons evenButton;

    @FindBy(id = "calculate-button")
    public Button calculateButton;

    @FindBy(css = "#elements-checklist input")
    public Checklist elements;

    @JDropdown(root = "#colors",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown color;

    @JDropdown(root = "#metals",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables",
               value = "span.filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown vegetablesDropDown;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void submit(MetalAndColors metalAndColors) {
        oddButton.select(metalAndColors.getSummary().get(0).toString());
        evenButton.select(metalAndColors.getSummary().get(1).toString());
        calculateButton.click();
        for (String element : metalAndColors.getElements()) {
            elements.select(element);
        }
        color.select(metalAndColors.getColor());
        metals.select(metalAndColors.getMetals());
        vegetablesDropDown.select("Vegetables");
        for (String vegetable : metalAndColors.getVegetables()) {
            vegetablesDropDown.select(vegetable);
        }
        submit.click();
    }
}
