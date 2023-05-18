package desktop.screens;

import desktop.component.Input;
import org.openqa.selenium.By;

public class NotePad {

    private final Input editor = new Input((By.className("Edit")));

    public void setText(String text) {
        editor.setText(text + "\n");
    }

    public void clearText() {
        editor.clear();
        boolean a = editor.getText().isEmpty();
    }

    public boolean isFileEmpty() {
        return editor.getText().isEmpty();
    }
}
