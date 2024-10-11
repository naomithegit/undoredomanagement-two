
import java.util.Stack;

public class UndoRedoManager {
    private Stack<String> undoStack;  // To store actions for undo
    private Stack<String> redoStack;  // To store actions for redo

    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Method to perform an action
    public void performAction(String action) {
        undoStack.push(action);    // Store the action in undoStack
        redoStack.clear();         // Clear redoStack since new actions make redo invalid
        System.out.println("Action performed: " + action);
    }

    // Method to undo an action
    public void undo() {
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();  // Pop the last action
            redoStack.push(action);           // Push the undone action to redoStack
            System.out.println("Undo: " + action);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Method to redo an action
    public void redo() {
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();  // Pop the last undone action from redoStack
            undoStack.push(action);           // Push it back to undoStack as it's redone
            System.out.println("Redo: " + action);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public static void main(String[] args) {
        UndoRedoManager manager = new UndoRedoManager();

        manager.performAction("Action 1");  // Perform Action 1
        manager.performAction("Action 2");  // Perform Action 2

        manager.undo();  // Undo Action 2
        manager.redo();  // Redo Action 2
        manager.undo();  // Undo Action 2 again
        manager.undo();  // Undo Action 1
        manager.redo();  // Redo Action 1
    }
}
