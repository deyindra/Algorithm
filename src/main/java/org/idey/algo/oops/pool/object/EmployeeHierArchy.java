package org.idey.algo.oops.pool.object;

import java.util.*;

/**
 * Design Employee Hierarchy
 */
public class EmployeeHierArchy {
    //This will contains all mamager Id and List of Employee as immediate report
    private Map<Integer, List<Integer>> map;
    //This will contains employee and manager relationship
    private Map<Integer, Integer> employeeManager;

    public EmployeeHierArchy() {
        this.map = new HashMap<>();
        this.employeeManager = new HashMap<>();
        loadEmployeeHierArchy();
    }

    //Add command to add Manager Id and employee ID
    private void add(Integer managerId, Integer employeeId){
        List<Integer> list;
        if(managerId==null){
            managerId = -1;
        }
        list = map.computeIfAbsent(managerId, k -> new ArrayList<>());
        list.add(employeeId);
        employeeManager.put(employeeId,managerId);

    }

    //This will load all the employee manager record inside the data structure. Perhaps this will read the data
    //from external file
    private void loadEmployeeHierArchy(){
        add(null,1);
        add(1,2);
        add(1,3);
        add(2,4);
        add(3,5);
        add(5,6);
    }

    //Check given a employee ID if he is manager
    private boolean isManager(int employeeId){
        return isEmployee(employeeId) && map.containsKey(employeeId);
    }

    //Check if the employee ID is valid
    private boolean isEmployee(int employeeId){
        return employeeManager.containsKey(employeeId);
    }

    //Given a employee ID return the manager of the employee at certain level this is DFS search
    public Integer getEmployeeManagerAtLevel(int employeeId, int level){
        if(!isEmployee(employeeId) || level<=0){
            throw new IllegalArgumentException();
        }
        if(employeeManager.get(employeeId)==-1){
            return employeeId;
        }else{
            return getEmployeeManagerAtLevel(employeeId,level,1);
        }


    }
    //Helper function for EmployeeManager At level
    private Integer getEmployeeManagerAtLevel(int employeeId, int level, int currentLevel){
        int managerId= employeeManager.get(employeeId);
        if(managerId==-1){
            return employeeId;
        }else{
            if(currentLevel==level){
                return managerId;
            }else{
                return getEmployeeManagerAtLevel(managerId, level,currentLevel+1);
            }
        }

    }
    //Given a manager ID return all employees at certain level, it will be BFS search
    public List<Integer> getEmployeeAtLevel(int managerId, int level){
        if(!isManager(managerId)){
            throw new IllegalArgumentException();
        }
        if(level==0){
            return Collections.singletonList(managerId);
        }
        return getEmployeeAtLevelRecurrsive(managerId, level);
    }
    //Helper function for return employee at certain level
    private List<Integer> getEmployeeAtLevelRecurrsive(int managerId, int level){
      LinkedList<Integer> queue = new LinkedList<>();
      int currentLevel=0;
      int nodeInCurrentLevel = 1;
      int nodeInNextLevel = 0;
      queue.offer(managerId);
      while (!queue.isEmpty() && currentLevel<level){
          int id = queue.poll();
          nodeInCurrentLevel--;
          List<Integer> list = map.get(id);
          if(list!=null && !list.isEmpty()){
              nodeInNextLevel = list.size();
              queue.addAll(list);
          }
          if(nodeInCurrentLevel==0){
              nodeInCurrentLevel = nodeInNextLevel;
              nodeInNextLevel=0;
              currentLevel++;
          }
      }
      return queue;
    }



    public static void main(String[] args) {
        EmployeeHierArchy employeeHierArchy = new EmployeeHierArchy();
       System.out.println(employeeHierArchy.getEmployeeAtLevel(3,2));
       System.out.println(employeeHierArchy.getEmployeeManagerAtLevel(4,2));
    }

}
