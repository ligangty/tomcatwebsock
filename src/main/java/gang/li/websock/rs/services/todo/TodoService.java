/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gang.li.websock.rs.services.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author gli
 */
@Path("/todoService")
public class TodoService {

    private static Map<String, Todo> todoList = new HashMap<String, Todo>();

    static {

        Todo todo1 = new Todo();
        todo1.setId("1");
        todo1.setContent("Fabrizio");
        todo1.setDone(false);
        todoList.put(todo1.getId(), todo1);

        Todo todo2 = new Todo();
        todo2.setId("2");
        todo2.setContent("Justin");
        todo2.setDone(true);
        todoList.put(todo2.getId(), todo2);

    }


    @GET
    @Path("/todos")
    @Produces("application/xml")
    public List<Todo> listTodos() {
        return new ArrayList<Todo>(todoList.values());
    }

    @GET
    @Path("/todo/{todoId}")
    @Produces("application/xml")
    public Todo getTodoById(@PathParam("todoId") String todoId) {
        return todoList.get(todoId);
    }

    @GET
    @Path("/json/todos/")
    @Produces("application/json")
    public List<Todo> listTodosJSON() {
        return new ArrayList<Todo>(todoList.values());
    }

    @GET
    @Path("/json/todo/{todoId}")
    @Produces("application/json")
    public Todo getTodoJSONById(@PathParam("todoId") String todoId) {
        return todoList.get(todoId);
    }
}
