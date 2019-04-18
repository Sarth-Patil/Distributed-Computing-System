import mpi.MPI;

public class mp1 {

  public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    MPI.Init(args);
    
    int rank = MPI.COMM_WORLD.Rank();
    System.out.println("I'm a process with rank" + rank);
    if(rank == 0) {
      int [] buff = new int[2];
      buff[0] = 1;
      MPI.COMM_WORLD.Send(buff, 0, 1, MPI.INT, 1, MPI.ANY_SOURCE);
      MPI.COMM_WORLD.Recv(buff, 0, 1,MPI.INT, 1, MPI.ANY_SOURCE);
      System.out.println("results" + buff[0]);
      
    } else {

      int [] recBuff = new int[2];
      recBuff[0] = 1;
      MPI.COMM_WORLD.Recv(recBuff, 0, 1,MPI.INT, 0, MPI.ANY_SOURCE);
      recBuff[0] = 3*recBuff[0];      
      MPI.COMM_WORLD.Send(recBuff, 0, 1, MPI.INT, 0, MPI.ANY_SOURCE);
    }
    
    MPI.Finalize();

  }

}