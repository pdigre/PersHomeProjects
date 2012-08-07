import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

import no.esito.genova.model.core.QObject;
import no.esito.genova.model.generator.QGeneratorTarget;

public class GenovaBase2 extends GenovaFunctions implements Callable<CharSequence>{

	public QObject context;
	public QGeneratorTarget target;
	public String outputdir;
	
	@Override
	public CharSequence call() throws Exception {
		return null;
	}

	public class GVariable{

	}

	public CharSequence typedef2(String name,Object closure){
		return "";
	}
	
	public String variable(String name) {
		return new String();
	}

	public boolean hasVariable(String name) {
		return true;
	}

	public String variable(String name, String name2) {
		return new String();
	}

	public String variable(String name, String name2, String name3) {
		return new String();
	}

	public String variable(String name, String name2, String name3,
			String name4) {
		return new String();
	}

	public class GAttribute {

	}

	public boolean isContext(String name){
		return true;
	}
	public String attribute(String name) {
		return new String();
	}

	public String attribute(String name, String name2) {
		return new String();
	}

	public String attribute(String name, String name2, String name3) {
		return new String();
	}

	public boolean hasAttribute(String name) {
		return false;
	}

	public boolean hasAttribute(String name, String name2) {
		return false;
	}

	public boolean hasAttribute(String name, String name2, String name3) {
		return false;
	}

	public int intAttribute(String name) {
		return 1;
	}

	public int intAttribute(String name, String name2) {
		return 1;
	}

	public int intAttribute(String name, String name2, String name3) {
		return 1;
	}

	public void set(XVariable variable, Object value) {

	}

	public void warning(String string) {

	}

	public void error(String string) {

	}

	public void info(String string) {

	}

	public void debug(String string) {

	}

	public void indent(int indent){
		
	}
	
	public Object include(String filename){
		return new Object();
	}
	
	public boolean bool(Object input){
		if(input instanceof String)
			return !"".equals(input) && !"False".equalsIgnoreCase((String) input);
		if(input instanceof Boolean)
			return ((Boolean) input).booleanValue();
		return false;
	}

	public <X extends Object> X choose(boolean doFirst, X first, X second) {
		return doFirst ? first : second;
	}

	public boolean _DEFINED(XProperty property) {
		return true;
	}

	public void breakLoop(){
		
	}
	
	public void continueLoop(){
		
	}
	
	public void iterateGroup(Object closure){
		
	}
	
	public void iterateMember(Object closure){
		
	}
	
	public void iterateParameter(Object closure){
		
	}
	
	public void iterateGeneralization(Object closure){
		
	}
	
	public void iterateRealization(Object closure){
		
	}
	
	public void iterateAssociation(Object closure){
		
	}
	
	public Collection<Object> iterateAttribute(){
		return new ArrayList<Object>();
	}
	
	public Collection<Object> iterateClass(){
		return new ArrayList<Object>();
	}
	
	public Collection<Object> iterateInterface(){
		return new ArrayList<Object>();
	}
	
	public Collection<Object> iterateEnumerator(){
		return new ArrayList<Object>();
	}
	
	public Collection<Object> iterateGroup(){
		return new ArrayList<Object>();
	}
	
	public Collection<Object> iterateMember(){
		return new ArrayList<Object>();
	}

	public Collection<Object> iterateGeneralization(){
		return new ArrayList<Object>();
	}

	public Collection<Object> iterateRealization(){
		return new ArrayList<Object>();
	}

	public Collection<Object> iterateMethod(){
		return new ArrayList<Object>();
	}

	public Collection<Object> iterateAssociation(){
		return new ArrayList<Object>();
	}

	public Collection<Object> iterateParameter(){
		return new ArrayList<Object>();
	}

	public Collection<Object> iterateEnumValue(){
		return new ArrayList<Object>();
	}

	
	public String macro(String name){
		return new String();
	}
	
	public void setContext(String name){
		
	}
	
	public void file(String name){
		
	}
	public void newfile(String name){
		
	}
	public void line(){
		
	}
	public void endline(){
		
	}
	public void endfile(){
		
	}
	public void endContext(){
		
	}
	
	public void str(String func){
		
	}
	public String strEnd(){
		return "";
	}
	public String typed(String func){
		return "";
	}
}
