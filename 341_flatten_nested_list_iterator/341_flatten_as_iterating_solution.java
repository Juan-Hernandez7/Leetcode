public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack =new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() -1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();

    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()){
               return true; 
            }
            else{

                List<NestedInteger> curr = stack.pop().getList();
                for(int i = curr.size() -1; i >= 0; i--){
                    stack.push(curr.get(i));

                }
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
