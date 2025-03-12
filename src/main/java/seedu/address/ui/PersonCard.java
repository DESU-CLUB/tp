package seedu.address.ui;

import java.util.Comparator;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.ui.util.IconUtil;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label degree;
    @FXML
    private HBox degreeBox;
    @FXML
    private HBox phoneBox;
    @FXML
    private HBox addressBox;
    @FXML
    private HBox emailBox;
    @FXML
    private FlowPane tags;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label school;
    @FXML
    private HBox skillsBox;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);

        // Degree and School with icons
        degreeBox.getChildren().add(0, IconUtil.createIcon(FontAwesomeIcon.GRADUATION_CAP, "white"));
        degree.setText(person.getDegree().value);
        degreeBox.getChildren().add(2, new Label("•")); // Add bullet point
        degreeBox.getChildren().add(3, IconUtil.createIcon(FontAwesomeIcon.UNIVERSITY, "white"));
        school.setText(person.getSchool().value);

        // Phone with white icon
        phoneBox.getChildren().add(0, IconUtil.createIcon(FontAwesomeIcon.PHONE, "white"));
        phone.setText(person.getPhone().value);

        // Address with white icon
        addressBox.getChildren().add(0, IconUtil.createIcon(FontAwesomeIcon.HOME, "white"));
        address.setText(person.getAddress().value);

        // Email with white icon
        emailBox.getChildren().add(0, IconUtil.createIcon(FontAwesomeIcon.ENVELOPE, "white"));
        email.setText(person.getEmail().value);

        // Skills with white icon
        skillsBox.getChildren().add(0, IconUtil.createIcon(FontAwesomeIcon.TAGS, "white"));

        // Add tags
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }
}

