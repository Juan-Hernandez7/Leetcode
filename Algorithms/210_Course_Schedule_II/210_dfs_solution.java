class Solution {
    int place = 0;
    int[] order;
    HashSet<Integer> visited= new HashSet<>();
    boolean loop = false;

    public boolean dfsOrder(int course, HashMap<Integer,List<Integer>> courseMap){
        if(visited.contains(course)){
            loop =true;
            return false;
        }
        visited.add(course);

        List<Integer> prereqs = courseMap.get(course);

        for(int i = prereqs.size() - 1; i >=0; i--){
            if(prereqs.get(i) == -1){
                break;
            }

            if(!dfsOrder(prereqs.get(i), courseMap)){
                return false;
            }
            else{
                prereqs.remove(i);
            }
        }

        if(prereqs.isEmpty()){
            order[place] = course;
            place++;
            prereqs.add(-1);
        }

        visited.remove(course);

        return true;

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        HashMap<Integer, List<Integer>> courseMap= new HashMap<>();

        for(int i=0; i< numCourses; i++){
            courseMap.put(i, new ArrayList<Integer>());
        }

        for(int[] prereq: prerequisites){
            courseMap.get(prereq[0]).add(prereq[1]);
        }

        for(int i=0; i < numCourses; i++){
            if(!dfsOrder(i, courseMap)){
                break;
            }
        }

        if(loop){
            return new int[0];
        }

        return order;



    }
}