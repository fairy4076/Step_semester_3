package oop.class_problems.week5;

public class CrossPackageInheritance {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (accessorContext.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        if (accessorContext.equals("SAME_PACKAGE")) {
            if (fieldModifier.equals("private")) {
                return "DENIED";
            }
            return "ALLOWED";
        }

        if (accessorContext.equals("DIFFERENT_PACKAGE")) {
            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (accessorContext.equals(
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (fieldModifier.equals("protected")
                    || fieldModifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        if (accessorContext.equals(
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        return "DENIED";
    }


    static String describeContext(String accessorContext) {

        String[] words = accessorContext.split("_");

        String result = "";

        for (String word : words) {

            String formatted =
                word.substring(0, 1).toUpperCase()
                + word.substring(1).toLowerCase();

            if (!result.isEmpty()) {
                result += " ";
            }

            result += formatted;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );

        System.out.println(
            describeContext(
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );
    }
}