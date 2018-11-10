/*
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
*/

class Node {
    Node parent;
    String mailAddress;
    int nameId;
    
    Node(String mailAddress, int nameId) {
        this.mailAddress = mailAddress;
        this.nameId = nameId;
        this.parent = this;
    }
    
    Node getRoot() {
        Node root = this;
        while (root.parent != root)
            root = root.parent;
        return root;
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, Node> myMap = new HashMap<>();
        
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String address = account.get(j);
                if (!myMap.containsKey(address)) {
                    myMap.put(address, new Node(address, i));
                }       
                // Union find.
                myMap.get(account.get(j)).getRoot().parent = myMap.get(account.get(1)).getRoot();           
            }
        }
        
        // Group all nodes that have same roots to a same name index.
        Map<Integer, List<String>> map2 = new HashMap<>();  // Integer is the index, while List are addresses.
        for (Map.Entry<String, Node> e : myMap.entrySet()) {
            Node node = e.getValue();
            Integer id = node.getRoot().nameId;
            if (!map2.containsKey(id))
                map2.put(id, new ArrayList<>());
            map2.get(id).add(node.mailAddress);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> e : map2.entrySet()) {
            List<String> account = new ArrayList<>();
            // This is the name.
            account.add(accounts.get(e.getKey()).get(0));
            // These are the addresses.
            Collections.sort(e.getValue());
            for (String address : e.getValue())
                account.add(address);
            result.add(account);
        }
        return result;
    }
}