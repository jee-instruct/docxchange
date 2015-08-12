package com.vamsee.spring.lucene.beans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import org.apache.lucene.search.suggest.InputIterator;
import org.apache.lucene.util.BytesRef;

public class IndexFileIterator implements InputIterator{
	
	private Iterator<IndexFile> indexFileIterator;
    private IndexFile indexFile;

	public IndexFileIterator(Iterator<IndexFile> indexFileIterator) {
		super();
		this.indexFileIterator = indexFileIterator;
	}

	@Override
	public BytesRef next() throws IOException {
	        if (indexFileIterator.hasNext()) {
	        	indexFile = indexFileIterator.next();
	            try {
	                return new BytesRef(indexFile.getFileName().getBytes("UTF8"));
	            } catch (UnsupportedEncodingException e) {
	                throw new Error("Couldn't convert to UTF-8");
	            }
	        } else {
	            return null;
	        }
	}

	@Override
	public Comparator<BytesRef> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long weight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BytesRef payload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPayloads() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<BytesRef> contexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasContexts() {
		// TODO Auto-generated method stub
		return false;
	}

}
