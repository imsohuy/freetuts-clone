package com.group4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	Category findByCategoryName(String categoryName);
	
	Category findByCategoryId(Integer categoryId);
	
	@Query(value = "With CategoryList AS( "
			+ "	select parent.category_id "
			+ "	from category as parent "
			+ "	where parent.pre_category_id = :preCategoryId "
			+ "	union all "
			+ "	SELECT child.category_id "
			+ "	from category as child "
			+ "	Inner join CategoryList as CL "
			+ "	on child.pre_category_id = CL.category_id "
			+ "	where child.pre_category_id is not null ) "
			+ " select c.* from CategoryList c ", nativeQuery = true)
	List<Integer> findAllSubCatId(int preCategoryId);
	
	//chi dung de load bai tap len main page
	@Query(value = "With CategoryList AS( "
			+ "	select c.category_id from category c where c.category_name like ?1 ) "
			+ " select CL.* from CategoryList CL ", nativeQuery = true)
	List<Integer> findByCategoryNameLike(String categoryName);
	
	List<Category> findAll();
	
	List<Category> findByStatus(boolean status);
	
}
