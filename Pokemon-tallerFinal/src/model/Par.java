package model;

public class Par {

	int i;
	int j;

	public Par(int i, int j) {

		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	@Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (i*j);

        return result;
    }

     @Override
     public boolean equals(Object o) {

         if(!(o instanceof Par)) {
             return false;
         }

         if (o == this)
                return true;

             Par p = (Par)o;
         if(i==p.getI() && j == p.getJ()) {
             return true;
         }else {
             return false;
         }
     }

	
	
	
	

}
