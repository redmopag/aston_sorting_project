package aston.course_project.sorting.FillArraysOptions;

public class User {
    ArrayFillOption option;

    public void setOption(ArrayFillOption option) {
        this.option = option;
    }

    public void executeOption() throws Exception {
        option.fillArray();
    }
}

/*
    For using option write
    user.setOption(new Option)
    after
    user.executeOption();
*/

/*
    Example:
        User = new User();
        user.setOption(new FillArrayFromFileOption());
        user.executeOption();
 */


