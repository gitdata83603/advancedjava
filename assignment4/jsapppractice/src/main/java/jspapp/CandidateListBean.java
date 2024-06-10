package jspapp;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean 
{
    public List<Candidate> candlist()
    {
    	List<Candidate> list=new ArrayList<Candidate>();
    	try 
    	{
			CandidateDao cd=new CandidateDaoImpl();
			list=cd.findAll();
			System.out.println(cd);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }
}
