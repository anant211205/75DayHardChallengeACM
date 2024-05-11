class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length ;

        double result = Integer.MAX_VALUE ;
        
        
        double[][] workersRatio = new double[n][2] ;
        for(int worker=0;worker<n;worker++){  
            workersRatio[worker][0] = (double)wage[worker] / quality[worker] ;
            workersRatio[worker][1] = quality[worker] ;
        }

        Arrays.sort(workersRatio , (a,b)->Double.compare(a[0] , b[0])) ; //o(nlogn)

        // Approach-3 (Optimal)
        // T.C : O(nlogn + klogk + n*log(k))
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;

        double qualitySum = 0 ;
        for(int i=0;i<k;i++){
            pq.add((int)workersRatio[i][1]) ;
            qualitySum += workersRatio[i][1]; 
        }

        double managerRatio = workersRatio[k-1][0] ;
        result = managerRatio * qualitySum ;

        for(int manager=k;manager<n;manager++){
            managerRatio = workersRatio[manager][0] ;

            pq.add((int)workersRatio[manager][1]) ;
            qualitySum += workersRatio[manager][1] ;

            if(pq.size() > k){
                qualitySum -= pq.poll() ;
            }

            result = Math.min(result , qualitySum * managerRatio) ;
        }

        return result ;


        // better brute force
        // tc = O(nlogn + klogk + n*log(k))
        // for(int manager=k-1 ; manager<n;manager++){

        //     double managerRatio = workersRatio[manager][0] ;
        //     //Create a group of workers whose wage-to-quality ratio is less than or equal to the current manager's ratio
        //     double[] group = new double[manager+1] ;

        //     for(int worker=0 ; worker <= manager ; worker++){

        //         double workerWage = managerRatio * workersRatio[worker][1] ; 

        //         group[worker] = workerWage ;

        //     }            

        //     PriorityQueue<Double> pq = new PriorityQueue<>(group.length , Collections.reverseOrder()) ;

        //     double sum = 0 ;

        //     for(int i=0;i<group.length ;i++){
        //         sum += group[i] ;
        //         pq.add(group[i]) ;

        //         if(pq.size() > k){
        //             sum -= pq.poll() ;
        //         }
        //     }
        //     result = Math.min(result , sum) ;
        // }

        // return result ;



        // tc - > o(n * (n + klogk)) ;
        // for(int manager=0;manager<n;manager++){ // o(n)

        //     ArrayList<Double> ls = new ArrayList<>() ;
        //     double manRatio = (double)wage[manager] / quality[manager] ;

        //     for(int worker=0;worker<n;worker++){ //o(n)

        //         double workerWage = manRatio * quality[worker] ;

        //         if(workerWage >= wage[worker]){
                    
        //             ls.add(workerWage) ;
                
        //         }

        //     }
            
        //     if(ls.size() < k) continue ;
        //     //max heap for  finding minimum k wages
        //     PriorityQueue<Double> pq = new PriorityQueue<>(ls.size(), Collections.reverseOrder()) ;
        //     double sumWages = 0 ;
        //     for(Double i : ls){ // o(klogk)
        //         sumWages += i ;
        //         pq.add(i) ;

        //         if(pq.size() > k){
        //             sumWages -= pq.poll() ;
        //         }
        //     }
        //     result = Math.min(result , sumWages) ;
        // }
        // return result ;
    }
}