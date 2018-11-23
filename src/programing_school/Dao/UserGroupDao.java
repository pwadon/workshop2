package programing_school.Dao;

import programing_school.Entity.UserGroup;
import programing_school.service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {
    private static final String CREATE_user_group_QUERY = "INSERT INTO user_group(name) VALUES (?)";
    private static final String DELETE_user_group_QUERY = "DELETE FROM user_group where id = ?";
    private static final String FIND_ALL_UserGroups_QUERY = "SELECT * FROM user_group";
    private static final String Select_user_group_QUERY = "Select * from user_group where id = ?";
    private static final String UPDATE_user_group_QUERY = "UPDATE user_group SET  name = ? WHERE	id = ?";

    /**
     * Create UserGo
     *
     * @param userGroup
     * @return
     */
    public static  UserGroup create(UserGroup userGroup) {
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement insertStm = connection.prepareStatement(CREATE_user_group_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, userGroup.getName());

            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    userGroup.setId(generatedKeys.getInt(1));
                    return userGroup;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return null;
    }

    public static UserGroup selectUser(Integer id) {
        UserGroup UserGroup = new UserGroup();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(Select_user_group_QUERY);

        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UserGroup.setId(resultSet.getInt("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return UserGroup;

    }

    public static List<UserGroup> findAll() {
        List<UserGroup> userGroupList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_UserGroups_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                UserGroup UserGrouptoAdd = new UserGroup();
                UserGrouptoAdd.setId(resultSet.getInt("id"));
                UserGrouptoAdd.setName(resultSet.getString("name"));

               userGroupList.add(UserGrouptoAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return userGroupList;
    }
    public static void delete(Integer userId) {
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(DELETE_user_group_QUERY)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }



    public static void update(UserGroup userGroup) {
        try (Connection connection = DbUtil.getConnection("programing_school");
             PreparedStatement statement = connection.prepareStatement(UPDATE_user_group_QUERY);) {
            statement.setInt(2, userGroup.getId());
            statement.setString(1, userGroup.getName());


            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}

