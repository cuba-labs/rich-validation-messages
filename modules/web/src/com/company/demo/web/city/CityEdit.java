package com.company.demo.web.city;

import com.company.demo.entity.City;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.ValidationErrors;
import com.vaadin.ui.AbstractComponent;
import org.vaadin.addons.producttour.step.StepBuilder;
import org.vaadin.addons.producttour.tour.Tour;

import javax.inject.Named;
import java.util.Map;

public class CityEdit extends AbstractEditor<City> {
    @Named("fieldGroup.title")
    private TextField titleField;
    private Tour activeTour;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        titleField.addValueChangeListener(e ->
                cancelActiveTour()
        );

        unwrap(AbstractComponent.class).addDetachListener(event ->
                cancelActiveTour()
        );
    }

    private void cancelActiveTour() {
        if (activeTour != null) {
            activeTour.cancel();
            activeTour = null;
        }
    }

    @Override
    public void showValidationErrors(ValidationErrors errors) {
        super.showValidationErrors(errors);

        cancelActiveTour();

        activeTour = new Tour();

        activeTour.addStep(new StepBuilder()
                .withAttachTo(titleField.unwrap(AbstractComponent.class))
                .withTitle("Required fields")
                .withText("Title is required")
                .build());

        activeTour.start();
    }
}