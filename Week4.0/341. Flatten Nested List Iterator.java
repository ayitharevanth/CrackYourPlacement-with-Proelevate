public class NestedIterator implements Iterator<Integer> {
    
    List<Integer> result = new ArrayList<>();
    int index=0; 

    public NestedIterator(List<NestedInteger> nestedList) {
        
        for(int i =0 ; i < nestedList.size(); i++)  
        {
            if(nestedList.get(i).isInteger())  
                result.add(nestedList.get(i).getInteger());
            else{
                search(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return result.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<result.size();
    }
    public void search(NestedInteger data){
        if(data.isInteger())
            result.add(data.getInteger());
        else{
            for(int i =0; i <data.getList().size();i++){
                search(data.getList().get(i));
            }
        }
        
    }
}
