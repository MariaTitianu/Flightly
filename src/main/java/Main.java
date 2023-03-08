import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import model.Model;
import presenter.Presenter;
import view.ViewPtBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        LafManager.install(new DarculaTheme());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/colocviu_final", "root", "30Aprilie2002");
        ViewPtBD view = new ViewPtBD();
        Model model = new Model(connection);
        Presenter presenter = new Presenter(view, model);
        view.setVisible(true);

    }
}