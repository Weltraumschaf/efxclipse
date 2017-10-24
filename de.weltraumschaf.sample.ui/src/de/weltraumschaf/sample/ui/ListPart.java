package de.weltraumschaf.sample.ui;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.fx.core.event.EventBus;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ListPart {

	@Inject
	private EventBus b;
	private Label l = new Label();
	
	@PostConstruct
	void init(BorderPane parent) {
		parent.setCenter(l);
		b.subscribe(DetailPart.TOPIC, EventBus.data(this::handleTopic));
// IEventBRoker
//		b.subscribe("my/topic", e -> {
			// Leaks OSGi into this module!			
//		});
	}
	
	private void handleTopic(Date data) {
		
	}

	@Inject
	public void setCurrentTime(@Optional @Named("currentTime") Date date) {
		System.out.println("Context: " + date);
	}

	@Inject
	public void setCurrentTimeEvent(@UIEventTopic("my/topic") Date date) {
		// Better than subscribe to b, because it does not leak OSGi inside.
		System.out.println("Event: " + date);
	}
	
}
