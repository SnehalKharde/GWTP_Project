package demoSample.client.app.registration;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import demoSample.ArrayListStringCell;

import javax.inject.Inject;
import java.util.ArrayList;

public class RegistrationView extends ViewImpl implements RegistrationPresenter.MyView {

    interface Binder extends UiBinder<Widget, RegistrationView> {
    }
    @UiField
    TextBox username_edit;
    @UiField
    HTMLPanel usertable;
    @UiField
    Button go_to_add_edit;
    @Inject
    PlaceManager placeManager;
    CellTable<Employee> cellTable = new CellTable<Employee>();
    @Override
    public HasClickHandlers go_to_edit(){
        return go_to_add_edit;
    }
    @Override
    public void getTable(final ArrayList<Employee> employeeArrayList) {
          Column<Employee,ArrayList<String>> nameColumn = new Column<Employee,ArrayList<String>>(new ArrayListStringCell()) {
                @Override
                public ArrayList<String> getValue(Employee employee) {
                    ArrayList<String> cellInfo=new ArrayList<>();
                    cellInfo.add(employee.getName());
                    return cellInfo;
                }
            };
        Column<Employee,ArrayList<String>> usernameColumn = new Column<Employee,ArrayList<String>>(new ArrayListStringCell()) {
            @Override
            public ArrayList<String> getValue(Employee employee) {
                ArrayList<String> cellInfo=new ArrayList<>();
                cellInfo.add(employee.getUsername());
                return cellInfo;
            }
        };
        Column<Employee,ArrayList<String>> addressColumn = new Column<Employee,ArrayList<String>>(new ArrayListStringCell()) {
            @Override
            public ArrayList<String> getValue(Employee employee) {
                ArrayList<String> cellInfo=new ArrayList<>();
                cellInfo.add(employee.getAddress());
                return cellInfo;
            }
        };
        Column<Employee,ArrayList<String>> emailColumn = new Column<Employee,ArrayList<String>>(new ArrayListStringCell()) {
            @Override
            public ArrayList<String> getValue(Employee employee) {
                ArrayList<String> cellInfo=new ArrayList<>();
                cellInfo.add(employee.getEmail());
                return cellInfo;
            }
        };
        Column<Employee,ArrayList<String>> contactColumn = new Column<Employee,ArrayList<String>>(new ArrayListStringCell()) {
            @Override
            public ArrayList<String> getValue(Employee employee) {
                ArrayList<String> cellInfo=new ArrayList<>();
                cellInfo.add(employee.getContact());
                return cellInfo;
            }
        };
        Column<Employee,ArrayList<String>> genderColumn = new Column<Employee,ArrayList<String>>(new ArrayListStringCell()) {
            @Override
            public ArrayList<String> getValue(Employee employee) {
                ArrayList<String> cellInfo=new ArrayList<>();
                cellInfo.add(employee.getGender());
                return cellInfo;
            }
        };
            cellTable.addColumn(usernameColumn);
            cellTable.setRowCount(employeeArrayList.size(), true);

            cellTable.addColumn(usernameColumn);
            cellTable.addColumn(nameColumn);
            cellTable.addColumn(addressColumn);
            cellTable.addColumn(emailColumn);
            cellTable.addColumn(genderColumn);
            cellTable.addColumn(contactColumn);

            cellTable.setWidth("90%",true);
            cellTable.setColumnWidth(usernameColumn, 16, Style.Unit.PX);
            cellTable.setColumnWidth(nameColumn, 16, Style.Unit.PCT);
            cellTable.setColumnWidth(emailColumn, 20, Style.Unit.PCT);
            cellTable.setColumnWidth(genderColumn, 16, Style.Unit.PCT);
            cellTable.setColumnWidth(contactColumn, 20, Style.Unit.PCT);
            cellTable.setColumnWidth(addressColumn, 20, Style.Unit.PCT);

        usertable.add(cellTable);
    }

    @Override
    public String setUsernameToEdit(){
        return username_edit.getValue();
    }

    @Override
    public HasKeyPressHandlers getFetch() {
        return username_edit;
    }

    @Override
    public void addEditCheckBox() {

    }

    @Override
    public void clearTable() {
        usertable.clear();
    }

    @Inject
   public RegistrationView(
           Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
