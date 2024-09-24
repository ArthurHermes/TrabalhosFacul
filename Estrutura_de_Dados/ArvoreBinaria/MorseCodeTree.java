class TreeNode {
    char value;
    TreeNode left, right;

    TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    TreeNode() {
        this('\0');  // Valor nulo para os nós internos sem caracteres
    }
}

class MorseCodeTree {
    private TreeNode root;

    public MorseCodeTree() {
        root = new TreeNode();
        buildTree();
    }

    private void buildTree() {
        String[][] morseCode = {
            {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."}, {"F", "..-."},
            {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
            {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."},
            {"S", "..."}, {"T", "-"}, {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
            {"Y", "-.--"}, {"Z", "--.."}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, 
            {"4", "....-"}, {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."}, 
            {"9", "----."}, {"0", "-----"}
        };

        for (String[] entry : morseCode) {
            insert(entry[0].charAt(0), entry[1]);
        }
    }

    private void insert(char letter, String morseCode) {
        TreeNode current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new TreeNode();
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new TreeNode();
                }
                current = current.right;
            }
        }
        current.value = letter;
    }

    public String decode(String morseCode) {
        TreeNode current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                current = current.left;
            } else if (symbol == '-') {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }
        return String.valueOf(current.value);
    }

    public static void main(String[] args) {
        MorseCodeTree tree = new MorseCodeTree();
        String morseCodeMessage = ".- .-. - .... ..- .-.";
        String[] morseCodes = morseCodeMessage.split(" ");
        StringBuilder decodedMessage = new StringBuilder();

        for (String code : morseCodes) {
            decodedMessage.append(tree.decode(code));
        }

        System.out.println(decodedMessage.toString());  // Output: ARTHUR
    }
}
