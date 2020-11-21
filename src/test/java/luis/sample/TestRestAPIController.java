/* 
 * Copyright 2012-2014 the original author or authors. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0  
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
*/
package luis.sample;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import luis.sample.dados.Funcionario;
import luis.sample.service.FuncionarioService;
import java.util.Optional;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
//@SpringBootTest - cannot run app

public class TestRestAPIController { 


private static String KEY = "KEY"; 


//@Rule 
//public ExpectedException expectedEx = ExpectedException.none();

@Test 
@SuppressWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
public void testfindFuncionarioByLogin() { 
       FuncionarioService service =Mockito.mock(FuncionarioService.class); 
       
       Funcionario func = Mockito.mock(Funcionario.class);
       
       Mockito.doReturn(KEY).when(func).getLogin(); 
       Mockito.doReturn(Optional.of(func)).when(service).findFuncionarioByLogin(Mockito.anyString());

       RestAPIController api = Mockito.spy(RestAPIController.class); 
       api.funcionarioService = service; 

       Assert.assertTrue(api.findFuncionarioByLogin(KEY).isPresent()); 
       Assert.assertEquals(KEY, api.findFuncionarioByLogin(KEY).get().getLogin()); 
}

}
