class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        //<Content, List<filePath>>
        Map<String, List<String>> map = new HashMap<>();
        
        for(String path : paths){
            
            String[] directory = path.split(" ");
            String rootPath = directory[0];
            
            for(int i = 1; i < directory.length; i++){
                String content = directory[i].substring(directory[i].indexOf("("),directory[i].indexOf(")"));
                
                if(map.containsKey(content) == false) {
                    map.put(content,new ArrayList<>());
                }
                
                //1.txt(abcd)
                map.get(content).add(rootPath +"/" +directory[i].substring(0 ,directory[i].indexOf("(")));
            }
        }
        
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){

            // check for duplication
            if(entry.getValue().size()>1)
                list.add(entry.getValue());
        }
        return list;
        
    }
}