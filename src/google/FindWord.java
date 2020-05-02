package google;

class FindWord {
    public boolean exist(char[][] board, String word) {
        
        int currentPointer = 0;
        
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(currentPointer)){
                    currentPointer++;
                 return  exploreNearby(board,word,i,j,currentPointer);
                }
            }
        }
        
        return false;
        
    }
    
    
    public boolean exploreNearby(char[][] board, String word,int rowIndex,int columnIndex,int currentCharacterIndex){
        if(currentCharacterIndex==word.length()){
            return true;
        }
        
        if(getCharacterForPosition(board,rowIndex+1,columnIndex) == word.charAt(currentCharacterIndex)){
         return   exploreNearby(board,word,rowIndex+1,columnIndex,currentCharacterIndex+1);
            
        }else if(getCharacterForPosition(board,rowIndex-1,columnIndex) == word.charAt(currentCharacterIndex)){
      return      exploreNearby(board,word,rowIndex-1,columnIndex,currentCharacterIndex+1);
            
        } else if(getCharacterForPosition(board,rowIndex,columnIndex-1) == word.charAt(currentCharacterIndex)){
       return        exploreNearby(board,word,rowIndex,columnIndex-1,currentCharacterIndex+1);
         
        }else{
                       return exploreNearby(board,word,rowIndex,columnIndex+1,currentCharacterIndex+1);
        }
    }
    
    
    private char getCharacterForPosition(char[][] board,int i, int j){
        if(i<0||j<0||i>board.length-1||j>board[i].length-1){
            return '-';
        }else{
            return board[i][j];
        }
    }
}